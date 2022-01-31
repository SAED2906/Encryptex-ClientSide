package CLIENT;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class FileSender {


		
		public static void start(String Content) throws IOException, InterruptedException {
			FileSender client = new FileSender();
			SocketChannel socketChannel = client.CreateChannel(25575);
			client.sendFile(socketChannel, Content);
			
			
			
//			Path path = Paths.get("A:\\text.txt");
//			FileChannel fileChannel;
//			
//				fileChannel = FileChannel.open(path,
//						EnumSet.of(StandardOpenOption.CREATE,
//								StandardOpenOption.TRUNCATE_EXISTING,
//								StandardOpenOption.WRITE)
//						);
//			
//			//Allocate a ByteBuffer
			//socketChannelIn.socket().getInputStream();
			
//			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
////			
//			System.out.print("A");
//			String temp = "";
//			
//				while (socketChannelIn.read(buffer) > 0) {
//					buffer.flip();
//					String str = new String(buffer.array());
//					temp += str;
////						fileChannel.write(buffer);
//					
//					buffer.clear();
//				}
//				System.out.print(temp);
			
//				fileChannel.close();
//			
//			System.out.println("Receving file successfully!");
////			
				socketChannel.close();
				
////			
//			
			
			
			
			
			

		}

		private void sendFile(SocketChannel socketChannel, String content) throws IOException {

			//Read a file from disk. Its filesize is 54.3 MB (57,006,053 bytes)
			// receive the same size                 54.3 MB (57,006,053 bytes)
//			Path path = Paths.get("A:\\text.txt");
//			FileChannel inChannel = FileChannel.open(path);
			
			//File file = new File(content);
			
			//inChannel = FileChannel.open(file);
//			FileInputStream fin = new FileInputStream(file);
//			FileChannel inChannel = fin.getChannel();
//			
			String toWrite = content;
		    File tmpFile = File.createTempFile("test", ".tmp");
		    FileWriter writer = new FileWriter(tmpFile);
		    writer.write(toWrite);
		    writer.close();
		    
		    FileInputStream fin = new FileInputStream(tmpFile);
			FileChannel inChannel = fin.getChannel();
		    

//		    BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
//		    reader.readLine();
//		    reader.close();
			
			
			
			
			
			
			
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
			
			SocketAddress sockAddr = new InetSocketAddress("105.208.196.39", Port);
			socketChannel.connect(sockAddr);
			return socketChannel;
		}
		
		private void sendInstructions2(SocketChannel socketChannel) throws IOException {
			String temp = "test";
			//Read a file from disk. Its filesize is 54.3 MB (57,006,053 bytes)
			// receive the same size                 54.3 MB (57,006,053 bytes)
			socketChannel.socket().getOutputStream().write(temp.getBytes());
			//socketChannel.close();
		}

	}