package library;

public class ReadingRoom {

	private int[] seatNum = new int[35];
	private String userId;
	private boolean reservStatus = false; 
	private int startHour;
	private int startMinute;
	private int endHour;
	private int endMinute;
	private boolean entranceStatus = false;
	

	@Override
	public String toString() {
		System.out.println( "" + seatNum +"�� �ڸ� ");
		if(reservStatus) {
			System.out.println("\n�����  " + startHour + "��" + "StartMinute" + "�� ����"); 
			System.out.println(endHour + "��" + "endMinute" + "�� ����"); 
		}
		else{
			System.out.println("���డ��");
		}
		return "";
	}
	public boolean isEntranceStatus() {
		return entranceStatus;
	}

	public void setEntranceStatus(boolean entranceStatus) {
		this.entranceStatus = entranceStatus;
	}

	
	public boolean isReservStatus() {
		return reservStatus;
	}
	public void setReservStatus(boolean reservStatus) {
		this.reservStatus = reservStatus;
	}
	public int[] getseatNum() {
		for (int i = 0; i < seatNum.length; i++) {
			seatNum[i] =i + 1;
		}
		return seatNum;
	}
	public void setseatNum(int[] seatNum) {
		this.seatNum = seatNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStartMinute() {
		return startMinute;
	}
	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getEndMinute() {
		return endMinute;
	}
	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}
}
