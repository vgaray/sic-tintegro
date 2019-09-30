package pe.com.tintegro.services.util;

import java.util.ArrayList;
import java.util.List;

import pe.com.tintegro.dominio.IvrOpcion;

public class IVRUtil
{
	public static final String END_LINE = System.lineSeparator();
	public static final int DENIED_ENTER_ANNEX = 0;
	public static final int ACCEPT_ENTER_ANNEX = 1;
	public static final int RETURN_TO_START = 1;

	public static String generateStringSectorIVR(List< IvrOpcion > lsIvrOptions)
	{
		Node< IvrOpcion > root = lsIVROptionsParseToTree( lsIvrOptions );

		Queue< Node< IvrOpcion > > queueRootChildren = new Queue< Node< IvrOpcion > >();

		for ( Node< IvrOpcion > node : root.getChildren() )
		{
			queueRootChildren.enqueue( node );
		}

		return generateStringFileIVRSectorRecursive( "", root, queueRootChildren );
	}

	private static String generateStringFileIVRSectorRecursive(String strFile, Node< IvrOpcion > node, Queue< Node< IvrOpcion > > queueChildren)
	{
		if ( node != null )
		{
			IvrOpcion dataNode = node.getData();

			if ( dataNode != null && node.getChildren() != null && dataNode.getpIdtipo() == Util.IVR )
			{
				String nameFile = dataNode.getpNoAudio();

				// Obteniendo posicion de la extension del archivo
				int indexExtension = nameFile.lastIndexOf( "." );
				// Extrayendo la extension del nombre del archivo
				String nameExtension = null;
				if ( indexExtension != -1 )
				{
					nameExtension = nameFile.substring( indexExtension );
					nameFile = nameFile.substring( 0, indexExtension );
				}
				else
					nameFile = "<no presenta>";

				strFile += END_LINE + String.format( "[%s]", dataNode.getpNoNombre() ) + 
						     END_LINE + "exten => s,1,Answer()" + 
						     END_LINE + "exten => s,n,NoOp(ID LLAMANTE = ${CALLERID(num)})";
				
				if( nameExtension != null && nameExtension.equals( ".mp3" ) )
				{
					strFile += END_LINE + "exten => s,n,Set(VOLUME(TX)=9)" +
							     END_LINE + "exten => s,n,Set(VOLUME(RX)=9)";
				}
				
				strFile += END_LINE + "exten => s,n,Background(ivr/" + nameFile + ")" + 
						     END_LINE + "exten => s,n,WaitExten(" + dataNode.getpTiempoEspera() + ")" + 
						     END_LINE;

				if ( !node.isLeaf() )
				{
					List< Node< IvrOpcion >> lsChildren = node.getChildren();
					IvrOpcion data = null;
					String redirect = null;
					for ( Node< IvrOpcion > child : lsChildren )
					{
						data = child.getData();
						redirect = data.getpNuAnexo() == null || data.getpNuAnexo().equals( "" ) ? data.getpNoNombre() : data.getpNuAnexo();
						if( data.getpIdtipo() == Util.IVR_OPTION )
							strFile += END_LINE + "exten => " + data.getpNoValor() + ",1,Goto(anexos," + redirect + ",1)" + END_LINE + "exten => " + data.getpNoValor() + ",n,Hangup()" + END_LINE;
						else
							strFile += END_LINE + "exten => " + data.getpNoValor() + ",1,Goto(" + redirect + ",s,1)" + END_LINE + "exten => " + data.getpNoValor() + ",n,Hangup()" + END_LINE;

						queueChildren.enqueue( child );
					}
				}

				if ( dataNode.getpMarcaAnexo() == ACCEPT_ENTER_ANNEX )
				{
					strFile += END_LINE + "exten => _XXX,1,Answer()" + END_LINE + "exten => _XXX,n,Goto(anexos,${EXTEN},1)" + END_LINE + "exten => _XXX,n,Hangup()" + END_LINE + END_LINE + "exten => _XXXX,1,Answer()" + END_LINE + "exten => _XXXX,n,Goto(anexos,${EXTEN},1)" + END_LINE
							+ "exten => _XXXX,n,Hangup()" + END_LINE;
				}

				strFile += END_LINE + "exten => i,1,Playback(invalid)" + END_LINE + "exten => i,n,Goto(s,1)" + END_LINE;

				if ( dataNode.getpVuelveInicioTiempo() != null && dataNode.getpOperadora() == 1 && ( dataNode.getpNoAnexoTiempo() != null && !dataNode.getpNoAnexoTiempo().equals( "" ) ) )
					strFile += END_LINE + "exten => t,1,Goto(anexos," + dataNode.getpNoAnexoTiempo() + ",1)";

				int priority = dataNode.getpOperadora() == 1 ? 2 : 1;

				// if( dataNode.getpNoAnexoTiempo() == null ||
				// dataNode.getpNoAnexoTiempo().equals( "" ) )
				strFile += END_LINE + "exten => t," + priority + ",Hangup()" + END_LINE;
			}

			return generateStringFileIVRSectorRecursive( strFile, queueChildren.dequeue(), queueChildren );
		}

		return strFile;
	}

	private static Node< IvrOpcion > lsIVROptionsParseToTree(List< IvrOpcion > lsIvrOptions)
	{
		List< Node< IvrOpcion > > lsNodos = new ArrayList< Node< IvrOpcion > >();

		for ( int i = 0; i < lsIvrOptions.size(); i++ )
		{
			lsNodos.add( new Node< IvrOpcion >( lsIvrOptions.get( i ) ) );
		}

		IvrOpcion ivrOpcionAux = null;
		int idPadre = 0, idHijo = 0;
		for ( int i = 0; i < lsIvrOptions.size(); i++ )
		{
			ivrOpcionAux = lsIvrOptions.get( i );

			for ( int j = 0; j < lsIvrOptions.size(); j++ )
			{
				idPadre = ivrOpcionAux.getId();
				idHijo = lsIvrOptions.get( j ).getParent();

				if ( idHijo == idPadre )
				{
					lsNodos.get( i ).addChild( lsNodos.get( j ) );
				}
			}
		}

		Node< IvrOpcion > root = new Node< IvrOpcion >();

		for ( int i = 0; i < lsNodos.size(); i++ )
		{
			if ( lsNodos.get( i ).getData().getParent() == 0 )
			{
				root.addChild( lsNodos.get( i ) );
			}
		}

		return root;
	}
}
