package ljl.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Title: Lambda
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/28 10:49
 */
interface Mathoperation {
	int operation(int a, int b);
}

interface GreetingServer {
	void print(String message);
}

@FunctionalInterface interface Supplier<T> {
	T get();
}

class Car {
	static Car create(Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}

}

class Test1 {
	List m1(List<Integer> list, Predicate<Integer> p) {
		return (List) list.stream().filter(p).collect(Collectors.toList());
	}
}

public class Lambda {
	public static void main(String[] args) {
		//test1();
		//test1();
		//test5();
	/*	int[] data = { 2, 9,14, 83, 4, 1, 12 };
		int[] two = getTow(data);
		System.out.println(Arrays.toString(two));*/
		test8();
	}

	public static void test1() {
		Mathoperation add = (a, b) -> a + b;
		Mathoperation sub = (int a, int b) -> a - b;
		Mathoperation multiption = (int a, int b) -> {
			return a * b;
		};
		System.out.println(add.operation(1, 2));
		System.out.println(multiption.operation(1, 2));

	}

	public static void test2() {
		int num = 1;
		Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
		s.convert(2);
	}

	public interface Converter<T1, T2> {
		void convert(int i);
	}

	public static void test3() {
		Car car1 = Car.create(Car::new);
		Car car2 = Car.create(Car::new);
		Car car3 = Car.create(Car::new);
		List<Car> cars = Arrays.asList(car1, car2, car3);
		cars.forEach(Car::collide);
		cars.forEach(Car::repair);
		cars.forEach(car3::follow);

	}

	public static void test4() {
		List list = Arrays.asList(7, 8, 5, 9, 1);
		Test1 t = new Test1();
		List l = t.m1(list, n -> n > 5);
		System.out.println(l);
	}

	public static void test5() {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		String f = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("||"));
		System.out.println(f);
	}

	public static int[] getTow(int[] data) {
		int max = data[0], second = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				 second = max;
				 max=data[i];
			}else if(data[i]>second){
				second=data[i];
			}
		}
		return new int[] { max, second };
	}

	public static void test6() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());

	}

	public static void test7() {
		// 获取当前的日期时间

		LocalDateTime currentTime = LocalDateTime.now();

		System.out.println("当前时间: " + currentTime);
		LocalDateTime curTime = LocalDateTime.of(2019,3,1,0,0,0);
		curTime =curTime.minusDays(1);
		System.out.println(curTime);
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
		System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);
		// 12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);
		// 22 小时 15 分钟
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);
		// 解析字符串
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);

	}
	public static void test8(){
		//byte[] bs =Base64.getEncoder().encode("abc你好".getBytes());
		String s = Base64.getUrlEncoder().encodeToString("abc你好".getBytes());
		byte[]bs = Base64.getUrlDecoder().decode(s);
		String t = new String(bs);
		System.out.println(t);
	}

}
