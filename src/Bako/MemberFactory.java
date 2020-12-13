package Bako;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class MemberFactory {
    private final MemberArchive memberArchive;
    private Personals per;
    private LocalDate eDate;
    private LocalDate today;
    private int pointSum;
    private int memberNo;
    private final static int SILVER_LIMIT = 25000;
    private final static int GOLD_LIMIT = 70000;
    private int bonusPoint;
    private final int DAYS_OF_YEAR = 365;

    public MemberFactory(Personals per, LocalDate eDate)
    {   this.per = per;
        this.eDate = eDate;
        this.today = LocalDate.now();
        this.memberArchive = new MemberArchive();
        this.memberNo = memberArchive
                .addMember(per, eDate, pointSum,bonusPoint); }

    private long sinceRegistered(LocalDate eDate){
        return ChronoUnit.DAYS.between(eDate,today);
    }
    public IRegister registerPointFactory(int memberNo,int bonusPoint)
    {
        //Dersom summen av opptjente poing er mer/lik enn 25000
        // men mindre 70000 og er ikke mer enn et år siden registrering

        if((pointSum >= SILVER_LIMIT) &&
                (pointSum < GOLD_LIMIT) &&
                (sinceRegistered(this.eDate) < DAYS_OF_YEAR))
        {
            //lager objekt av interfacet dynamisk
            memberArchive.setMembershipType(new SilverMember());
            //beregner poing i følge laget objektet her Silver
            this.bonusPoint = memberArchive.getMembershipType()
                    .registerPoint(memberNo, bonusPoint);
            //legger til summen av opptjente poing
            pointSum+=this.bonusPoint;

            return new SilverMember(memberNo, per, eDate,
                                    pointSum, this.bonusPoint); }

        else if(pointSum>=GOLD_LIMIT &&
                sinceRegistered(this.eDate)<=DAYS_OF_YEAR)
        {
            //memberType(new GoldMember(memberNo,personals,
            // enrolledDate,pointSum,this.bonusPoint));

            memberArchive.setMembershipType(new GoldMember());
            //returnerer den beregnet bonusPoint
            this.bonusPoint = memberArchive.getMembershipType()
                    .registerPoint(memberNo, bonusPoint);

            pointSum+=this.bonusPoint; //legger til hele summen

            return new GoldMember(memberNo, per,
                                  eDate, pointSum, this.bonusPoint);
        }
        else {
            memberArchive.setMembershipType(new BasicMember());
            this.bonusPoint = memberArchive.getMembershipType()
                    .registerPoint(memberNo, bonusPoint);

            pointSum+=this.bonusPoint;
            return new BasicMember(memberNo, per,
                                   eDate, pointSum, this.bonusPoint);
        }

    }
    public int getMemberNo() {
        return memberNo;
    }

}
