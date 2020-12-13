package Bako;

import java.time.LocalDate;

public class GoldMember extends BonusMember implements IRegister {
    private final float GOLD_FACTOR = 1.5F;
    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int sumPoint,int bonusPoint) {
        super(memberNo, personals, enrolledDate,sumPoint,bonusPoint);
    }
    public GoldMember(){}
    @Override
    public int registerPoint(int memberNO, int bonusPoint) {

        return (int) (bonusPoint*GOLD_FACTOR);
    }

    @Override
    public String toString() {
        return
                "|"+getMemberNo()+ "   |"+getPersonals().getSurname() +" \t\t|"+ getBonusPoints() +"\t\t|"+"Gold Member"+"\t\t|"+
                        getSumPoint()+"\t\t\t|\t"+getEnrolledDate()+"\t\t|" ;
    }

}
