package CLIENT;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReciever {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		FileReciever client = new FileReciever();
		SocketChannel socketChannelIn = client.CreateChannel(25585);
		client.sendInstructions(socketChannelIn);
		
		
//		Path path = Paths.get("A:\\text.txt");
//		FileChannel fileChannel;
//		
//			fileChannel = FileChannel.open(path,
//					EnumSet.of(StandardOpenOption.CREATE,
//							StandardOpenOption.TRUNCATE_EXISTING,
//							StandardOpenOption.WRITE)
//					);
//		
//		//Allocate a ByteBuffer
		//socketChannelIn.socket().getInputStream();
		
//		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
////		
//		System.out.print("A");
//		String temp = "";
//		
//			while (socketChannelIn.read(buffer) > 0) {
//				buffer.flip();
//				String str = new String(buffer.array());
//				temp += str;
////					fileChannel.write(buffer);
//				
//				buffer.clear();
//			}
//			System.out.print(temp);
		
//			fileChannel.close();
//		
//		System.out.println("Receving file successfully!");
////		
			
			socketChannelIn.close();
////		
//		
		
		
		
		
		

	}

	private void sendFile(SocketChannel socketChannel) throws IOException {

		//Read a file from disk. Its filesize is 54.3 MB (57,006,053 bytes)
		// receive the same size                 54.3 MB (57,006,053 bytes)
		Path path = Paths.get("A:\\text.txt");
		FileChannel inChannel = FileChannel.open(path);
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (inChannel.read(buffer) > 0) {
			buffer.flip();
			socketChannel.write(buffer);
			buffer.clear();
		}
		socketChannel.close();
	}

	private SocketChannel CreateChannel(int Port) throws IOException {
		//Remember that is code only works on blocking mode
		SocketChannel socketChannel = SocketChannel.open();
		
		//we don't need call this function as default value of blocking mode = true
		socketChannel.configureBlocking(true);
		
		SocketAddress sockAddr = new InetSocketAddress("localhost", Port);
		socketChannel.connect(sockAddr);
		return socketChannel;
	}
	
	private void sendInstructions(SocketChannel socketChannel) throws IOException {
		String temp = "test";
		//Read a file from disk. Its filesize is 54.3 MB (57,006,053 bytes)
		// receive the same size                 54.3 MB (57,006,053 bytes)
		socketChannel.socket().getOutputStream().write(temp.getBytes());
		//socketChannel.close();
	}

}



