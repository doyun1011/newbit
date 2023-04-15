package java230406;

public class BeanFactory {

	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new samsungTv();
		}
		else if (beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}
}
