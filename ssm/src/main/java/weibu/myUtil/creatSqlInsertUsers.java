package weibu.myUtil;

public class creatSqlInsertUsers {

	public static void main(String[] args) {
		int item=500;
		StringBuffer sql=new StringBuffer();
		sql.append("insert into user (username,password) values");
		for (int i = 0; i <item; i++) {		
			sql.append(" \n("+"'T用户"+i+"',"+"'T密码"+i+"')");
			if(i<item-1) {
				sql.append(",");
			}
			if(i==item-1){
				sql.append(";");
			}
		}
		System.out.println(sql);
	}

}
