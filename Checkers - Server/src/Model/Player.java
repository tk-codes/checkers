package Model;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Server Application -> Player
 * @author Siyar
 * 
 * Player Model
 */
public class Player{
	private int PlayerID;
	private Socket socket;
	private DataInputStream fromPlayer;
	private DataOutputStream toPlayer;
	
	public Player(int ID, Socket s){
		this.PlayerID = ID;
		this.socket = s;
		
		try{
			fromPlayer = new DataInputStream(socket.getInputStream());
			toPlayer = new DataOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public int sendData(int data){
		try {
			this.toPlayer.writeInt(data);
			return 1; //Successfull
		} catch (IOException e) {
			System.out.println("sending: Player not found");
			//e.printStackTrace();
			return 99;	//failure
		}		
	}
	
	public int receiveData(){
		int data = 0;;
		try{
			data = this.fromPlayer.readInt();
			return data;
		}catch (IOException e) {
			System.out.println("Waiting: No respond from Player");
			return 99;
		}
	}
	
	public void closeConnection(){
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isOnline(){
		return socket.isConnected();
	}
}
