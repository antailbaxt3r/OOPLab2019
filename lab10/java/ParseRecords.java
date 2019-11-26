import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;

public class ParseRecords{

	//fields
	HashMap<String,Student> IDtoStudentObj;
	HashMap<String,Batch> batchtoBatchObj;

	//consructor
	public ParseRecords(){
		this.IDtoStudentObj = new HashMap<String, Student>();
		this.batchtoBatchObj = new HashMap<String, Batch>();
	}

	int getRecords(String filename){

		BufferedReader bReader;

		try{
			bReader = new BufferedReader(new FileReader(filename));
		}catch(FileNotFoundException e){
			System.out.println(e.toString());
			return -1;
		}

		int numberOfRecords = 0;

		while(true){

			try{
				String record = bReader.readLine();
				if (record == null) {
					break;
				}
				
				String[] recordList = record.split(" ");				

				String id = recordList[0];
				String name = recordList[1];
				String sem = recordList[2];
				String gpa = recordList[3];

				Student student = new Student(id, name);
				Batch batch = new Batch(student.getBatch());

				if (IDtoStudentObj.get(id) != null) {
					Student s = IDtoStudentObj.get(id);
					s.addGPA(sem, gpa);
					IDtoStudentObj.put(id, s); 

				}else{
					IDtoStudentObj.put(id, student); 
				}

				if (batchtoBatchObj.get(student.getBatch()) != null) {
					Batch b = batchtoBatchObj.get(student.getBatch());
					b.addStudenttoBatch(student);
					batchtoBatchObj.put(student.getBatch(), b);
				}else{
					batchtoBatchObj.put(student.getBatch(), batch);
				}

				numberOfRecords++;

			}catch(IOException e){
				return -1;
			}
		}

		return numberOfRecords;
		
	}

	int getStudentSize(){
		return IDtoStudentObj.size();
	}

	void answerQueries(String inputfile, String outputfile){


		BufferedReader bReader;
		BufferedWriter bWriter;
		try{
			bReader = new BufferedReader(new FileReader(inputfile));
		}catch(FileNotFoundException e){
			return;
		}

		try{

			bWriter = new BufferedWriter(new FileWriter(outputfile));
		}catch(IOException e){
			return;
		}


		while(true){
			try{
				String query = bReader.readLine();
				if (query == null) {
					break;
				}
				String queryBreak[] = query.split(" ");
				String queryNo = queryBreak[0];
			
					switch(queryNo){
						case "Q1" :
							String id = queryBreak[1];
							queryQ1(id, outputfile, bWriter);
							break;
						case "Q2" :
						String batch2 = queryBreak[1];
							queryQ2(batch2, bWriter);
							break;
						// case "Q3" :
						// 	queryQ3();
						// 	break;
						// case "Q4" :
						// 	queryQ4();
						// 	break;
						case "Q5" :
							String batch = queryBreak[1];
							String branch = queryBreak[2];
							queryQ5(batch, branch, bWriter);
							break;
						
				}

			}catch(IOException e){
				return;
			}

			try{
				bWriter.flush();
			}catch(IOException e){
				return;
			}
		}





		// try{
		// 	String q = bReader.readLine();
		// 	String id = q.split(" ")[1];

		// 	try{
		// 		BufferedWriter bWriter = new BufferedWriter(new FileWriter(outputfile));
		// 		try{
		// 			bWriter.write(IDtoStudentObj.get(id).studentInfo());
		// 			bWriter.flush();
		// 		}catch(IOException e){
		// 			return;
		// 		}

		// 	}catch(FileNotFoundException e){
		// 		return;
		// 	}

			
		// }catch(IOException e){
		// 	return;
		// }

		// //Query 2
		// try{
		// 	String q = bReader.readLine();
		// 	String batch = q.split(" ")[1];

		

		// 	ArrayList<Student> list = batchtoBatchObj.get(batch).allStudent();

		// 	BufferedWriter bWriter;
		// 	for (int i = 0; i < list.size; i++) {
		// 		try{
		// 			bWriter = new BufferedWriter(new FileWriter(outputfile));
		// 			try{
		// 				bWriter.write(IDtoStudentObj.get(id).studentInfo());
		// 				bWriter.flush();
		// 				}catch(IOException e){
		// 					return;
		// 				}
		// 		}catch(FileNotFoundException e){
		// 		return;
		// 	}
		// 	}







				

			

			
		// }catch(IOException e){
		// 	return;
		// }

		

	}



	public static void main(String args[]){
		ParseRecords p = new ParseRecords();
		System.out.println(p.getRecords("file.txt"));
		System.out.println(p.getStudentSize());

		p.answerQueries("queries.txt", "answers.txt");
	}


	public void queryQ1(String id, String outputfile, BufferedWriter bWriter){
		
				try{
					bWriter.append(IDtoStudentObj.get(id).studentInfo());
				}catch(IOException e){
					return;
				}

	}

	public void queryQ5(String batch, String branch, BufferedWriter bWriter){
			try{
					bWriter.append(batchtoBatchObj.get(batch).findMaxCGPA(branch).studentInfo());
				}catch(IOException e){
					return;
				}
	}

	public void queryQ2(String batch, BufferedWriter bWriter){

	ArrayList<Student> list = batchtoBatchObj.get(batch).allStudents();
		for (int i = 0; i < list.size(); i++){
		try{
			bWriter.append(IDtoStudentObj.get(list.get(i).getID()).studentInfo());
			}catch(IOException e){
			return;
			}

		}
	}


}