package Bako;

import java.time.LocalDate;

public class SilverMember extends BonusMember implements IRegister {

    private final float SILVER_FACTOR = 1.2F;
    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int sumPoint,int bonusPoint) {
        super(memberNo, personals, enrolledDate,sumPoint,bonusPoint);

    }
public SilverMember(){}

    @Override
    public int registerPoint(int memberNO, int bonusPoint) {
        return (int) (bonusPoint*SILVER_FACTOR);
    }

    @Override
    public String toString() {
        return
                "|"+getMemberNo()+ "   |"+getPersonals().getSurname() +" \t\t|"+ getBonusPoints() +"\t\t|"+"Silver Member"+"\t\t|"+
                        getSumPoint()+"\t\t\t|\t"+getEnrolledDate()+"\t\t|" ;
    }

    }


