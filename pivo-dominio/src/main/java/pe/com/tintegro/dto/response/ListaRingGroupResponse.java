package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.RingGroup;

public class ListaRingGroupResponse extends ResponseBase
{
   private List<RingGroup> listRingGroup;
   
   public List<RingGroup> getListRingGroup()
	{
		return listRingGroup;
	}
   
   public void setListRingGroup(List<RingGroup> listRingGroup)
	{
		this.listRingGroup = listRingGroup;
	}
}
