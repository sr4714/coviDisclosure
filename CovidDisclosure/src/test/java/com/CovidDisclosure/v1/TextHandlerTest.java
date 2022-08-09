package com.CovidDisclosure.v1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.CovidDisclosure.v1.siddharth.TextHandler;

@RunWith(MockitoJUnitRunner.class)
public class TextHandlerTest {

	    @Test
	    public void verifyCallToIsOpenConnection() throws InterruptedException, IOException {
	         WebSocketSession session = mock(WebSocketSession.class);
	         TextMessage textMsg = new TextMessage("Test Message".getBytes());

	         when(session.isOpen()).thenReturn(true);

	         TextHandler textHandler = new TextHandler();

	         // Pass the mocked session object here
	         textHandler.handleTextMessage(session, textMsg);

	         // Now you can verify if session.sendMessage() was called or not
	         verify(session, times(1)).sendMessage(textMsg);
	    }
	}


