package polymorphism;

public class Tv {
	// ��� ����
	private int channel;
	
	// setter, getter
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	// �޼ҵ�
	public void channelUp() {
		this.channel +=1; 
	}
	
	// toString
	@Override
	public String toString() {
		return "Tv [channel=" + channel + "]";
	}
	
	
	
}
