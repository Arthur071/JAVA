class PatientInfo{
    static String patient_name;
    static int age;
    static int contact_number;

    public static void Patient(String name,int Page, int Pcontact){
            patient_name = name;
            age = age;
            contact_number = Pcontact;

    }

    public static void displayInfo(){
        System.out.println("The name of the patient is : " + patient_name + "\nthe age of the patient is : " + age + "\n the contact number of the patient is : " + contact_number);
    }


}

class Patient{
    public static void main(String[] args) {
        PatientInfo userID1 = new PatientInfo();
        userID1.Patient("krishnesh", 67, 45354);       
    }
}