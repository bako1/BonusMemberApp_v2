package Bako;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Used secure Random generator which is more secure than Random generator
 * */
public class MemberArchive {
    private final SecureRandom randomGenerator;
    private BasicMember basicMember;
    private IRegister member;


    public MemberArchive() {
        randomGenerator = new SecureRandom();
        //bonusMemberMap = new HashMap<>();
        basicMember = new BasicMember(22, new Personals("Abdi", "Bako",
                                                        "" + "ab@gmail.com", "8976"),
                                      LocalDate.now(), 1, 0);
    }
    /**
     * @param member member type of a member to be created at runtime.
     *
     *
     * */
    public void setMembershipType(IRegister member){
        this.member = member;

    }
    /**
     * @return returns a member of Type interface IRegister
     * */
    public IRegister getMembershipType(){return  member;}
    /**
     * Generates random number between 10000000 and 99999999 until new number is unique
     *
     * @return returns a unique random number that can be used later as a member number
     */
    public int findAvailableNumber() {

        int randomNo = 10000000 + randomGenerator.nextInt(89999999);
        while (randomNo == basicMember.getMemberNo()) {
            randomNo = 10000000 + randomGenerator.nextInt(99999999);
        }
        return randomNo;
    }

    /**
     * @param personals    personal object
     * @param dateEnrolled enrolled date
     * @return returns member number of a user
     */
    public int addMember(Personals personals, LocalDate dateEnrolled, int sumPoint, int bonusPoint) {
        basicMember = new BasicMember(findAvailableNumber(), personals, dateEnrolled, sumPoint, bonusPoint);
        //bonusMemberMap.put(basicMember.getMemberNo(), basicMember);
        return basicMember.getMemberNo();
    }
}



