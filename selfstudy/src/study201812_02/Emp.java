package study201812_02;

public class Emp {
	private int age;
	private String name;
	private String gender;
	private int salary;
	public Emp(){ //重载构造一般要加上空构造方法
		
	}
	public Emp(String name,String gender,int age,int salary) {
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.salary=salary;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [age=" + age + ", name=" + name + ", gender=" + gender + ", salary=" + salary + "]";
	}
	//Java文件空白处右键->source->generate hashCode() and equals()->自动生成该方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
