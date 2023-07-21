package scheduled;

import org.springframework.stereotype.Component;

@Component(value="swork")
public class ScheduledWork {
	static int i=0;
	public void work() {
		
		System.out.println("5초마다 작업 실행"+i++);
	}
}
