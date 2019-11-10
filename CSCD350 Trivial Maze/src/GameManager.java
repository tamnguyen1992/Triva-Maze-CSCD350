import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

enum TypeOfQuestion{
	TrueFalse, MultipleChoice, ShortAnswer;
}
public class GameManager {
	public static void insertQuestion(String question, String correctAns, String wrAns1, String wrAns2, String wrAns3, int type, int status) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Question.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "INSERT INTO Question(Question,CorrectAnswer,WrongAnswer1,WrongAnswer2,WrongAnswer3,TypeOfQuestion,Status)"+
							"VALUES ('"+question+"','"+correctAns+"','"+wrAns1+"','"+wrAns2+"','"+wrAns3+"',"+type+","+status+")";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");
			stmt.close();
		    c.close();
	   }catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
	   }
	}
	public static void selectData() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Question.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT * FROM Question";
			ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("QuestionID");
		         String question = rs.getString("Question");
		         String correctAns = rs.getString("CorrectAnswer");
		         String wrongAns1 = rs.getString("WrongAnswer1");
		         String wrongAns2 = rs.getString("WrongAnswer2");
		         String wrongAns3 = rs.getString("WrongAnswer3");
		         int type = rs.getInt("TypeOfQuestion");
		         int status = rs.getInt("Status");

		         //Display values
		         System.out.print("QuestionID: " + id);
		         System.out.print(", Question: " + question);
		         System.out.print(", Correct Answer: " + correctAns);
		         System.out.print(", Wrong Answer 1: " + wrongAns1);
		         System.out.print(", Wrong Answer 2: " + wrongAns2);
		         System.out.print(", Wrong Answer 3: " + wrongAns3);
		         System.out.print(", Type Of Question: " + type);
		         System.out.println(", Status: " + status);
		      }
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertQuestion("Where can you find London bridge today", "USA","England","France","Gemany",TypeOfQuestion.MultipleChoice.ordinal(),0);
		selectData();
		
	}

}
