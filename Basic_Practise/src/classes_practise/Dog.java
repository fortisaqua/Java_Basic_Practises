package classes_practise;


class Social_ID{
    String ID_num;

    Social_ID(String ID){
        ID_num=ID;
    }
}

public class Dog {
    String breed;
    int age;
    String color;
    private Social_ID id;

    public Dog(String breed_type){
        breed=breed_type;
        id = new Social_ID("social id 1");
    }

    public Dog(String breed_type,int age_num){
        breed=breed_type;
        age=age_num;
    }

    public String Get_Breed(){
        return breed;
    }

    public int Get_age(){
        return age;
    }

    public void Set_age(int new_age){
        age=new_age;
    }

    void barking(){

    }
    void hungry(){

    }
    void sleeping(){

    }
}
