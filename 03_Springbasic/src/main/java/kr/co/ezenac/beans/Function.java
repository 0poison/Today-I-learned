package kr.co.ezenac.beans;

public class Function {
	public static void main(String[] args) {
		java.util.function.Function<Member, Address> functionA;
		java.util.function.Function<Address, String> functionB;
		java.util.function.Function<Member, String> functionAB;
		String city;

		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();
		functionAB = functionA.andThen(functionB);
		city = functionAB.apply(new Member("홍길동", "hong", new Address("한국", "서울")));
		System.out.println("거주 도시: " + city);

		functionAB = functionB.compose(functionA);
		city = functionAB.apply(new Member("홍길동", "hong", new Address("한국", "서울")));

		System.out.println("거주 도시: " + city);
	}
}
