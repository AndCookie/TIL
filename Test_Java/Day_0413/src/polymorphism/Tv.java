package polymorphism;

public class Tv {
	// 멤버 변수
	private int channel;
	
	// setter, getter
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	// 메소드
	public void channelUp() {
		this.channel +=1; 
	}
	
	// toString
	@Override
	public String toString() {
		return "Tv [channel=" + channel + "]";
	}
	
	
	
}
