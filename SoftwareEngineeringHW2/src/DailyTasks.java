import java.util.*;
import java.io.*;


class PhoneBook{
	String id;
	String name;
	String phoneNumber;
	int phoneIndex;
}

class Schedule{
	String id;
	Date date;
	String description;
	int scheduleIndex;
}

class Note{
	String id;
	String note;
	int noteIndex;
}



class Statement{
	
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;

	private String makeDatabaseName(int state){
		String databaseName = "";
		if(state == PHONEBOOK)
			databaseName = "PhoneBook";
		else if(state == SCHEDULE)
			databaseName = "Schedule";
		else if(state == NOTE)
			databaseName = "Note";
		else
			;//Exception
		return databaseName;
	}
	
	private String makeAttributesStringForAddition(int state){
		
		String databaseAttributes = "";
		if(state == PHONEBOOK)
			databaseAttributes = "(id, name, phoneNumber, phoneIndex ) ";
		else if(state == SCHEDULE)
			databaseAttributes = "(id, date, description, scheduleIndex ) ";
		else if(state == NOTE)
			databaseAttributes = "(id, note, noteIndex ) ";
		else
			;//Exception
		return databaseAttributes;
	}
	
	private String makeValueStringForAddition(int state, int maxIndex){
		
		Scanner scan = new Scanner(System.in);
		String valuesForAddition = "";
		InputFromUser inputFromUser = new InputFromUser();
		if(state == PHONEBOOK){
			PhoneBook valuesForPhoneBook = inputFromUser.queryAndSetPhoneBook(maxIndex);
			valuesForAddition = "values("
								+ valuesForPhoneBook.id + ", "
								+ valuesForPhoneBook.name +", "
								+ valuesForPhoneBook.phoneNumber + ", "
								+ valuesForPhoneBook.phoneIndex + ")";
		}
		else if(state == SCHEDULE){
			Schedule valuesForSchedule = inputFromUser.queryAndSetSchedule(maxIndex);
			valuesForAddition = "values("
								+ valuesForSchedule.id + ", "
								+ valuesForSchedule.date + ", "
								+ valuesForSchedule.description + ", "
								+ valuesForSchedule.scheduleIndex + ") ";
		}
		else if(state == NOTE){
			Note valuesForNote = inputFromUser.queryAndSetNote(maxIndex);
			valuesForAddition = "values(" 
								+ valuesForNote.id + ", "
								+ valuesForNote.note + ", "
								+ valuesForNote.noteIndex + ")";
		}
		else{
			//exception
		}
		return valuesForAddition;
	}
	
	private String makeIndexName(int state){
		String indexName = "";
		if(state == PHONEBOOK)
			indexName = "phoneIndex";
		else if(state == SCHEDULE)
			indexName = "scheduleIndex";
		else if(state == NOTE)
			indexName = "noteIndex";
		else
			;
		return indexName;
	}

	private String makeStatementForAddition(int state, int maxIndex){
		String sqlStatement;
		sqlStatement = "INSERT INTO " 
						+ makeDatabaseName(state)
						+ makeAttributesStringForAddition(state)
						+ makeValueStringForAddition(state, maxIndex);
		return sqlStatement;
	}
	
	private String makeStatementforViewing(int state){
		String sqlStatement;
		sqlStatement = "SELECT * FROM " + makeDatabaseName(state);
		return sqlStatement;
	}
	
	private String deleteStatementforViewing(int state, int selectedIndex){
		String sqlStatement;
		sqlStatement = "DELETE FROM " + makeDatabaseName(state)
						+ "WHERE " + makeIndexName(state) + "=" + selectedIndex;
		return sqlStatement;
	}
	
}





class InputFromUser{
	
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;
	
	public PhoneBook queryAndSetPhoneBook(int index){
		
		Scanner scan = new Scanner(System.in);
		PhoneBook phoneBookForAddition = new PhoneBook();
		///id
		System.out.print("name : ");
		phoneBookForAddition.name = scan.nextLine();
		System.out.print("phone : ");
		phoneBookForAddition.phoneNumber = scan.nextLine();
		phoneBookForAddition.phoneIndex = index;
		return phoneBookForAddition;
	}
	
	public Schedule queryAndSetSchedule(int index){
		
		Scanner scan = new Scanner(System.in);
		Schedule scheduleForAddition = new Schedule();
		///id
		int year, month, day;
		System.out.print("date : ");
		year = scan.nextInt();
		month = scan.nextInt();
		day = scan.nextInt();
		scheduleForAddition.date = new Date(year, month, day);
		System.out.print("description : ");
		scheduleForAddition.description = scan.nextLine();
		scheduleForAddition.scheduleIndex = index;
		return scheduleForAddition;
	}
	
	public Note queryAndSetNote(int index){
		
		Scanner scan = new Scanner(System.in);
		Note noteForAddition = new Note();
		//id
		System.out.print("["+index+"] note : " );
		noteForAddition.note = scan.nextLine();
		noteForAddition.noteIndex = index;
		return noteForAddition;
	}
	
	private void queryForindexNumber(int state){
		
		if(state == PHONEBOOK){
			System.out.print("����� ���� ����� �ε����� �Է��ϼ���: ");
		}
		else if(state == SCHEDULE){
			System.out.print("����� ���ϴ� ������ �ε����� �Է��� �ּ���: ");
		}
		else if(state == NOTE){
			System.out.print("����� ���ϴ� ��Ʈ�ε����� �Է��� �ּ��� : ");
		}
		else{
			// Exception
		}
	}
	
	private void reQueryForindexNumber(int state){
		
		if(state == PHONEBOOK){
			System.out.print("��ȣ �ε����� �ٽ� �Է����ּ��� : ");
		}
		else if(state == SCHEDULE){
			System.out.print("������ �ε����� �ٽ� �Է��� �ּ��� : ");
		}
		else if(state == NOTE){
			System.out.print("��Ʈ�ε����� �ٽ� �Է��� �ּ��� : ");
		}
		else{
			// Exception
		}
	}
}






public class DailyTasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
