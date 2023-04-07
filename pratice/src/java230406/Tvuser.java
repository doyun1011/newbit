package java230406;

public class Tvuser {

	public static void main(String[] args) {
		BeanFactory bean = new BeanFactory();
		TV tvSamsung = (TV)bean.getBean("samsung");
		TV tvLg = (TV)bean.getBean("lg");
		
		tvSamsung.powerOn();
		tvSamsung.volumeUp();
		tvSamsung.volumedown();
		tvSamsung.powerOff();
		
		System.out.println();
		
		tvLg.powerOn();
		tvLg.volumeUp();
		tvLg.volumedown();
		tvLg.powerOff();
	}
}
