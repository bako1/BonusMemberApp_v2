package Bako;
import java.time.LocalDate;
public class Client {
   // private static MemberFactory memberFactory;


    public static void main(String[] args) {
        //Skaper p1,p2,p3 Persons objekter
        Personals p1 =
                new Personals("Abdi","Bako","jon@gmail.com","4554");
        Personals p2 =
                new Personals("Hansen","Eyob","eyo@gmail.com","5125");
        Personals p3 =
                new Personals("Ezu","Olav","ezu@gmail.com","6543");
        //Registrere Personene p1,p2,p3 i systemet

        MemberFactory reg_2018 = new MemberFactory(p1,LocalDate.of(2018,1,1));
        MemberFactory reg_2020_1 = new MemberFactory(p2,LocalDate.of(2020,1,1));
        MemberFactory reg_2020_12 = new MemberFactory(p3,LocalDate.of(2020,12,12));
        //Alle medlemmer er av type basic når de registreres
        //register poing til, p1,p2 og p3 for første gang
        System.out.println("\n****************************** Member Bonus App *********************************************\n");

        System.out.println("\nRegister poing for første gang (Alle medlemmer er basic i begynnelsen uanset poingsum)");
        System.out.println("+-------------------------------------------------------------------------------------------+\n" +
                                   "|Member No    |Surname \t| Know Earned | Member Type\t\t| Sum Earned \t| \tEnrolled Date \t|\n" +
                                   "+-------------------------------------------------------------------------------------------+" );
        System.out.println(reg_2018.registerPointFactory(reg_2018.getMemberNo(),30000));
        System.out.println(reg_2020_1.registerPointFactory(reg_2020_1.getMemberNo(),30000));
        System.out.println(reg_2020_12.registerPointFactory(reg_2020_12.getMemberNo(),30000));

        //Register poing neste gang
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("\nRegister poing for andre gang (medlemstypen bestemmes av poingsum og registerert dato)");

        System.out.println("+-------------------------------------------------------------------------------------------+\n" +
                                   "|Member No    |Surname \t| Know Earned | Member Type\t\t| Sum Earned \t| \tEnrolled Date \t|\n" +
                                   "+-------------------------------------------------------------------------------------------+" );
        System.out.println(reg_2018.registerPointFactory(reg_2018.getMemberNo(),10000));
        System.out.println(reg_2020_1.registerPointFactory(reg_2020_1.getMemberNo(),10000));
        System.out.println(reg_2020_12.registerPointFactory(reg_2020_12.getMemberNo(),50000));

        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("\n'Olav' Oppdateres til Gold neste gang han skjekker inn (kreves ingen poing nå)");
        System.out.println("+-------------------------------------------------------------------------------------------+\n" +
                                   "|Member No    |Surname \t| Know Earned| Member Type\t\t| Sum Earned \t| \tEnrolled Date \t|\n" +
                                   "+------------------------------------------------------------------------------------------+" );
        System.out.println(reg_2018.registerPointFactory(reg_2018.getMemberNo(),0));
        System.out.println(reg_2020_1.registerPointFactory(reg_2018.getMemberNo(),0));
        System.out.println(reg_2020_12.registerPointFactory(reg_2020_12.getMemberNo(),0));
        System.out.println("+------------------------------------------------------------------------------------------+");


    }
}
