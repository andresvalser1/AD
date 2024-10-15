package ejercico6;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

	public MyObjectOutputStream() throws IOException, SecurityException {
		// TODO Auto-generated constructor stub
	}

	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	
	protected void writeStreamHeader() throws IOException{
		
	}

}
