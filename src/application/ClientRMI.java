package application;

import java.rmi.Naming;

import org.sid.entity.Training;
import org.sid.service.StudentRmiService;
import org.sid.service.TrainingRmiService;

public class ClientRMI {

	public static void main(String[] args) {
		
		try {
			StudentRmiService stubStudent = (StudentRmiService) Naming
					.lookup("rmi://localhost:1099/" + StudentRmiService.class.getSimpleName());
			
			TrainingRmiService stubTraining = (TrainingRmiService) Naming
					.lookup("rmi://localhost:1099/" + TrainingRmiService.class.getSimpleName());
			
			stubStudent.getStudents().forEach(s -> {
				System.out.println("==============================");
				System.out.println("ID : " + s.getId());
				System.out.println("Last Name : " + s.getLastName());
				System.out.println("First Name : " + s.getFirstName());
				System.out.println("Training : " + s.getTraining());
			});
			
			System.out.println("\n\n");
			
			stubTraining.getTrainings().forEach(t -> {
				System.out.println("##############################");
				System.out.println("ID : " + t.getId());
				System.out.println("Name : " + t.getName());
				System.out.println("Duration : " + t.getDuration());
				System.out.println("Students : " + t.getStudents());
			});
			System.out.println("\n\n+++++++++++++++++++++++++");
			Training training = stubTraining.getTraining(2L);
			System.out.println("Get training by Id=" + training.getId());
			System.out.println("Name : " + training.getName());
			System.out.println("Duration : " + training.getDuration());
			System.out.println("Students : " + training.getStudents());			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 



	}

}
