package pe.com.tintegro.services;


import pe.com.tintegro.dto.request.SendMessageRequest;
import pe.com.tintegro.dto.response.SendMessageResponse;

public interface MessagesServerServices
{
	   
     public SendMessageResponse enviarMensajeCola (SendMessageRequest request) ;
}
