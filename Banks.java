public class Banks {
    private  String name;
    private  double interestRate;

    Banks(){
        name="blank";
        interestRate=0.0;
    }

    Banks(int idint,String nam,double rate){

        name=nam;
        interestRate=rate;
    }


    public String getName(){
        return name;
    }
    public double getRate(){
        return interestRate;
    }


    public void setName(String nam){
        name=nam;
    }
    public void setRate(double rate){
        interestRate=rate;
    }
    public String toString(){
        return "\nName: "+ name+"\nRate:"+interestRate;
    }

}
