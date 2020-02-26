//Artur Linnik assignment5 26.02.2020
import java.util.*;
import java.io.*;
import java.math.*;
class Player {
    public static boolean isSNearW(W w,ArrayList<S> ss){
        boolean out = false;
        int h = 0;
        for(int i=0; i<ss.size(); i++){
            if(absDistSW(ss.get(i), w) < 401){
                out = true;
                h = i;
            }
        }
        return out;
    }
    public static S getClosestToOurGoalS(ArrayList<S> ss, int myTeamId){
        int XMin = ss.get(0).x;
        int tSN = 0;
        if(myTeamId ==0){
            for(int i=0;i<ss.size();i++){
                if(XMin > ss.get(i).x){
                    XMin = ss.get(i).x;
                    tSN = i;
                }
            }
        }else{
            for(int i=0;i<ss.size();i++){
                if(XMin < ss.get(i).x){
                    XMin = ss.get(i).x;
                    tSN = i;
                }
            }
        }
        return ss.get(tSN);
    }
    public static int[] getSfarestId(ArrayList<S> ss , ArrayList<W> ws, int myTeamId){
        int outSId = 0, outWId=0;
        int dmax = 0;
        int xmin = 0; if(myTeamId == 0){ xmin = 15000;} else { xmin = 0; }
        int SN = 0;
        if(myTeamId == 0){
            for( int j=0; j < ss.size(); j++){
                if(ss.get(j).x < xmin){
                    xmin = ss.get(j).x;
                    outSId = ss.get(j).id;
                    SN = j; //looking for closest to our goal Snafle
                }
            }
            int W1Y = ws.get(0).y;
            int W2Y = ws.get(1).y;
            int SY = ss.get(SN).y;
            if(SY > 3750){
                if(W1Y < W2Y){
                    outWId = 0;
                }else{
                    outWId = 1;
                }
            }else{
                if(W1Y > W2Y){
                    outWId = 0;
                }else{
                    outWId = 1;
                }
            }
        }else{
            for( int j=0; j < ss.size(); j++){
                if(ss.get(j).x > xmin){
                    xmin = ss.get(j).x;
                    outSId = ss.get(j).id;
                    SN = j;
                }
            }
            int W1Y = ws.get(0).y;
            int W2Y = ws.get(1).y;
            int SY = ss.get(SN).y;
            if(SY > 3750){
                if(W1Y < W2Y){
                    outWId = 0;
                }else{
                    outWId = 1;
                }
            }else{
                if(W1Y > W2Y){
                    outWId = 0;
                }else{
                    outWId = 1;
                }
            }
        }
        int[] at = new int[2];
        at[0] = outSId; at[1] = outWId;
        return at;
    }
    public static int absDist(B b, W w){
        return (int)(Math.sqrt(Math.pow(b.x - w.x ,2) + Math.pow(b.y - w.y, 2)));
    }
    public static int absDistSW(S s, W w){
        return (int)(Math.sqrt(Math.pow(s.x - w.x ,2) + Math.pow(s.y - w.y, 2)));
    }
    public static int absDistOWS(OW ow, S s){
        return (int)(Math.sqrt(Math.pow(s.x - ow.x ,2) + Math.pow(s.y - ow.y, 2)));
    }
    public static void print(String s){
        System.err.println(s);
    }
    public static void OBLIV(int id, int mm){
        if(mm > 5){
                System.out.println("OBLIVIATE " + id);
        }
    }
    public static void PETRIF(int id, int mm){
        if(mm >= 10){
                System.out.println("PETRIFICUS " + id);
        }
    }
    public static void ACCIO(int id, int mm){
        if(mm >= 15){
                System.out.println("ACCIO " + id);
        }
    }
    public static void FLIP(int id, int mm){
        if(mm > 20){
                System.out.println("FLIPENDO " + id);
        }
    }
    public static boolean InOurGoalS(S s, int myTeamId){
        boolean out = false; double k=0.0;
        if(s.vx == 0) return false;
        if(myTeamId==0){
            k = (double)-s.vy / s.vx ;
            double b = - k  * s.x - s.y;
            if(b<-2100 && b > -5285)
                out = true;
            System.err.print("b= " + b + " ");
            }else{
                k = (double)-s.vy / s.vx ;
                double y = k * s.x - s.y;
                if(y < -2100 && y > -5285)
                    System.err.print("y= " + y + " k " + k + " ");
                    out = true;
            }
        return out;
        }
        public static OW getClosestOWToS(ArrayList<OW> ows,S s){
        double max = Math.sqrt(Math.pow(ows.get(0).x - s.x, 2) + Math.pow(ows.get(0).y - s.y, 2));
        OW owOut = new OW();
        for(int i=0; i<ows.size(); i++){
            double c = Math.sqrt(Math.pow(ows.get(i).x - s.x, 2) + Math.pow(ows.get(i).y - s.y, 2));
            if(max < c){
                owOut=ows.get(i);
                max = c;
            }
        }
        return owOut;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int myTeamId = in.nextInt(); // if 0 you need to score on the right of the map, if 1 you need to score on the left
        int OWmagicDiff=0;
        int xg=0, yg=0;
        int nMove = 0;
        int nMoveTemp1 = 0; int nMoveTemp2 = 0;
        if(myTeamId == 0){
            xg = 15999;
            yg = 3750;
        }else{
            xg = 0;
            yg = 3750;
        }
        ArrayList<S> Ss = new ArrayList<S>();
        ArrayList<S> Ss2 = new ArrayList<S>();
        ArrayList<W> Ws = new ArrayList<W>();
        ArrayList<OW> OWs = new ArrayList<OW>();
        ArrayList<B> Bs = new ArrayList<B>();
        ArrayList<int[]> SsPositions = new ArrayList<int[]>();// id x y coordinates
        ArrayList<Integer> OWmagic = new ArrayList<Integer>();
        int index1=0,index2=0;
        boolean NeedToUseMagic1 = false;
        boolean NeedToUseMagic2 = false;
        // game loop
        while (true) {
            nMove+=1;
            int myScore = in.nextInt();
            int myMagic = in.nextInt();
            int opponentScore = in.nextInt();
            int opponentMagic = in.nextInt();
            OWmagic.add(opponentMagic); if(nMove > 4) OWmagicDiff =1 +  OWmagic.get(OWmagic.size() -2) - OWmagic.get(OWmagic.size() -1) ;
            int entities = in.nextInt(); // number of entities still in game
            for (int i = 0; i < entities; i++) {
                int entityId = in.nextInt(); // entity identifier
                String entityType = in.next(); // "WIZARD", "OPPONENT_WIZARD" or "SNAFFLE" (or "BLUDGER" after first league)
                int x = in.nextInt(); // position
                int y = in.nextInt(); // position
                int vx = in.nextInt(); // velocity
                int vy = in.nextInt(); // velocity
                int state = in.nextInt(); // 1 if the wizard is holding a Snaffle, 0 otherwise
                if(entityType.equals("WIZARD")){
                    Ws.add(new W(entityId, x,y, vx,vy, state));   
                }
                if(entityType.equals("SNAFFLE")){
                    Ss.add(new S(entityId, x,y,vx,vy));
                    Ss2.add(new S(entityId, x,y,vx,vy));
                    //SsPositions.add({entityId, x, y});
                }
                if(entityType.equals("OPPONENT_WIZARD")){
                    OWs.add(new OW(entityId, x,y,vx,vy,state));
                }
                if(entityType.equals("BLUDGER")){
                    Bs.add(new B(entityId, x,y,vx,vy));
                }
            }
            //spell logic
            int lhs = 0, rhs=0;
            for(int i=0; i<Ss.size(); i++){
                if(Ss.get(i).x < 7500){
                    lhs +=1;
                }else{
                    rhs +=1;
                }
            }
            int WId = 0, WN = 0;
            int SfarId = 0 , SCritId = 0;
            int manaFor2Spell = 50;
            int manaFor0Spell = 55;
            int BId = 0;
            int disFor2Spell = 1500;
            boolean MUseSId0 = false;
            boolean MUseSId1 = false;
            boolean MUseSId2 = false;
            boolean MUseSId3 = false;
            ArrayList<S> tS = new ArrayList<S>();
            // spellId : spellName 0:OBLIV 1:PETRI 2:ACCIO 3:FLIP
            //Obliv spell
            if((absDist(Bs.get(0) ,Ws.get(1)) < disFor2Spell) && myMagic > manaFor0Spell && nMoveTemp2 == 0){
                MUseSId0 = true;
                NeedToUseMagic2 = true;
                BId = Bs.get(0).id;
                print("OBLIV1");
                nMoveTemp2 = 20;
            }
            if(absDist(Bs.get(1) ,Ws.get(1)) < disFor2Spell&& myMagic > manaFor0Spell&& nMoveTemp2 == 0){
                MUseSId0 = true;
                NeedToUseMagic2 = true;
                BId = Bs.get(1).id;
                print("OBLIV2");
                nMoveTemp2 = 20;
            }
            if((absDist(Bs.get(0) ,Ws.get(0)) < disFor2Spell) && myMagic > manaFor0Spell&& nMoveTemp1 == 0){
                MUseSId0 = true;
                NeedToUseMagic1 = true;
                BId = Bs.get(0).id;
                print("OBLIV3");
                nMoveTemp1 = 20;
            }
            if(absDist(Bs.get(1) ,Ws.get(0)) < disFor2Spell&& myMagic > manaFor0Spell&& nMoveTemp1 == 0){
                MUseSId0 = true;
                NeedToUseMagic1 = true;
                BId = Bs.get(1).id;
                print("OBLIV4");
                nMoveTemp1 = 20;
            }
            //Critical moment // myTeamId == 0
            boolean CriticalMoment = false;
            if(myTeamId == 0){
            for(int i=0; i<Ss.size() ; i++){
            //System.err.println("Sid vx vy : " + Ss.get(i).id+" "+ Ss.get(i).vx + " " + Ss.get(i).vy+ " inGoal "+ InOurGoalS(Ss.get(i), myTeamId));
            if(myMagic >= 10 && (absDistOWS(getClosestOWToS(OWs, Ss.get(i)),Ss.get(i)) > 3000 || Ss.size() == 1) && Ss.get(i).x<3000 && InOurGoalS(Ss.get(i) , myTeamId)){
                MUseSId1 = true;
                CriticalMoment = true;
                tS.add(Ss.get(i));
                if(Ws.get(0).state == 0){
                    NeedToUseMagic1 = true;
                }else if(Ws.get(1).state == 0){
                    NeedToUseMagic2 = true;
                }else{
                    NeedToUseMagic1 = true;
                }
                }
            }
            for(int i=0; i<Ss.size(); i++){
                if(Ss.get(i).vx <= 0 && Ss.get(i).x <3000 && myMagic >= 15 && !CriticalMoment){
                    SfarId = Ss.get(i).id;
                    MUseSId2 = true;
                    CriticalMoment = true;
                    if(Ws.get(0).x < Ws.get(1).x) NeedToUseMagic1 = true; else NeedToUseMagic2 = true;
                }
            }
            }else{ // myTeamId == 1
                for(int i=0; i<Ss.size() ; i++){
            System.err.println("Sid vx vy : " + Ss.get(i).id+" "+ Ss.get(i).vx + " " + Ss.get(i).vy+ " inGoal "+ InOurGoalS(Ss.get(i), myTeamId));
            if(myMagic >= 10 && (absDistOWS(getClosestOWToS(OWs, Ss.get(i)),Ss.get(i)) > 3000 || Ss.size() == 1)&& Ss.get(i).x> 13000 && InOurGoalS(Ss.get(i) , myTeamId)){
                MUseSId1 = true;
                tS.add(Ss.get(i));
                CriticalMoment = true;
                if(Ws.get(0).state == 0){
                    NeedToUseMagic1 = true;
                }else if(Ws.get(1).state == 0){
                    NeedToUseMagic2 = true;
                }else{
                    NeedToUseMagic1 = true;
                }
                break;
                }
            }
            for(int i=0; i<Ss.size(); i++){
                if(Ss.get(i).vx >= 0 && Ss.get(i).x > 13000 && myMagic > 15 && !CriticalMoment){
                    SfarId = Ss.get(i).id;
                    MUseSId2 = true;
                    CriticalMoment = true;
                    if(Ws.get(0).x < Ws.get(1).x) NeedToUseMagic1 = true; else NeedToUseMagic2 = true;
                }
            }
            }
            if(MUseSId1){
                double fastest = 0.0;
                for(int i=0; i<tS.size();i++){
                    if(Math.sqrt(Math.pow(tS.get(i).vx, 2) + Math.pow(tS.get(i).vy, 2)) > fastest){
                        fastest = Math.sqrt(Math.pow(tS.get(i).vx, 2) + Math.pow(tS.get(i).vy, 2));
                        SCritId = tS.get(i).id;
                    }
                }
            }
            
            //push to score
            int FlipWN=0, FlipSN = 0;
            if(myTeamId == 1){
                for(int j = 0; j< Ws.size(); j++){
                for(int i =0; i< Ss.size(); i++){
                    int tt = Ss.get(i).x;
                    if(Ss.get(i).x == Ws.get(j).x){
                        tt = Ss.get(i).x + 1;
                    }
                    double k = (double)( - Ss.get(i).y - (-Ws.get(j).y)) / ( tt - Ws.get(j).x);
                    double t = - k  * Ws.get(j).x - Ws.get(j).y;
                    double SpellPower = Math.min(6000/Math.pow((absDistSW(Ss.get(i) , Ws.get(j))/ 1000), 2), 1000 );
                    double SnafToWDist = absDistSW(Ss.get(i), Ws.get(j));
                    double StoGDist = Math.sqrt(Math.pow(Ss.get(i).x, 2) + Math.pow(Ss.get(i).y - t, 2));
                    boolean temp0 = false; 
                    if(Ss.size() == 1) temp0=true; 
                    else if(Ws.get(j==1?0:1).nearSId != Ss.get(i).id) temp0 = true; else temp0 = false;
                    if((Ss.size() ==1 && myMagic>19 &&  Ws.get(j).x - Ss.get(i).x > 0) || !CriticalMoment && t < -2400 && t > -5050  && Ws.get(j).x - Ss.get(i).x > 0 && Ws.get(j).x < 14500&& SnafToWDist * SpellPower/0.76 > StoGDist && myMagic > 20 && !Ss.get(i).used3Spell && temp0){ //&& SnafToWDist * SpellPower / 0.75 > StoGDist
                        FlipSN = i; FlipWN = j;
                        MUseSId3 = true;
                        Ss.get(i).used3Spell = true;
                        print("idSpell0");
                        System.err.println("Ws.get(temp).nearSId " + Ws.get(j==1?0:1).nearSId + " != Ss.get(i).id " +Ss.get(i).id);
                    }
                }}
            }else{
                // y = kx + b
                for(int j = 0; j< Ws.size(); j++){
                for(int i =0; i< Ss.size(); i++){
                    int tt = Ss.get(i).x;
                    if(Ss.get(i).x == Ws.get(j).x){
                        tt = Ss.get(i).x + 1;
                    }
                    double k = (double)( - Ss.get(i).y - (-Ws.get(j).y)) / ( tt - Ws.get(j).x);
                    double t =  k  * (15999 - Ws.get(j).x) - Ws.get(j).y;
                    //System.err.println("Wid " + Ws.get(j).id + " Sid " + Ss.get(i).id + " t=" + t + " k=" + k + " S vy " + Ss.get(i).vy);
                    double SpellPower = Math.min(6000/Math.pow((absDistSW(Ss.get(i) , Ws.get(j))/ 1000), 2), 1000 );
                    double SnafToWDist = absDistSW(Ss.get(i), Ws.get(j));
                    double StoGDist = Math.sqrt(Math.pow(Ss.get(i).x, 2) + Math.pow(Ss.get(i).y - t, 2));
                    int temp = 0; if(j==0) temp=1;else temp=0; boolean temp0 = false; if(Ss.size() == 1) temp0=true; else if(Ws.get(temp).nearSId != Ss.get(i).id) temp0 = true; else temp0 = false;
                    if((Ss.size() ==1 && myMagic>19 &&  Ws.get(j).x - Ss.get(i).x < 0) ||!CriticalMoment&& t < -2400 && t > -5050  && Ws.get(j).x - Ss.get(i).x < 0 && Ws.get(j).x < 14500 && SnafToWDist * SpellPower/0.76> StoGDist && myMagic > 20 && !Ss.get(i).used3Spell && temp0){ //&& SnafToWDist * SpellPower / 0.75 > StoGDist
                        FlipSN = i; FlipWN = j;
                        MUseSId3 = true;
                        Ss.get(i).used3Spell = true;
                        print("idSpell1");
                    }
                }}
            }
            if(MUseSId3 && myMagic > 20){
                if(FlipWN == 0){
                    NeedToUseMagic1 = true;
                }else{
                    NeedToUseMagic2 = true;
                }
            }
            //Focusing on onGoal S or Removing from Ss S which are close to scoring
            if(myTeamId == 0){
                int nOfRemoved =0;
                for(int i = 0; i< Ss.size(); i++){
                    if(lhs>=rhs && Ss.size() != 1 && Ss.get(i).x < 7500 && opponentScore - myScore>1){
                        Ss.remove(i - nOfRemoved);
                        nOfRemoved +=1;
                    }
                }
            }else{
                int nOfRemoved =0;
                for(int i = 0; i< Ss.size(); i++){
                    if(lhs <= rhs && Ss.size() != 1 && Ss.get(i).x > 7500 && opponentScore - myScore>1){
                        Ss.remove(i - nOfRemoved);
                        nOfRemoved +=1;
                    }
                }
            }
            
            if(!NeedToUseMagic1){
            int ygt1 = yg;int xt=0, yt =0, vxt=0, vyt = 0; double k=1;
            if(Ws.get(0).state == 0){
                int index = Ws.get(0).getClosestS(Ss);
                Ws.get(0).nearSId = Ss.get(index).id;
                System.err.println(Ws.get(0).nearSId);
                xt = Ss.get(index).x;
                yt = Ss.get(index).y;
                vxt = Ss.get(index).vx;
                vyt = Ss.get(index).vy;
                k=1;
                if(absDist(Bs.get(0) , Ws.get(0)) < 500 || absDist(Bs.get(1), Ws.get(0)) < 500){
                    k = Math.random() + 0.5;
                    if(k>1){
                        k=0.98;
                    }
                }
                print("id0");
                System.out.println("MOVE " + (int)((xt+vxt)*k) + " " + (int)((yt+vyt)*k) + " 150");
                
            }else{
                if(Ws.get(0).y > 3750){
                    ygt1 += 1100; 
                }else{
                    ygt1 -= 1100; 
                }
                print("id1");
                if(isSNearW(Ws.get(0), Ss)){
                    System.out.println("THROW "+ xg + " " + ygt1 + " 500");
                }else{
                    System.out.println("MOVE " + (int)((xt+vxt)*k) + " " + (int)((yt+vyt)*k) + " 150");
                }
            }
            }else{
                boolean used = false;
                if(MUseSId0 && !used){
                    OBLIV(BId, myMagic);
                    used = true;
                    print("id3");
                }
                if(MUseSId3 && !used){
                    FLIP(Ss.get(FlipSN).id, myMagic);
                    used = true;
                    print("id8");
                }
                if(MUseSId1 && !used){
                    PETRIF(SCritId, myMagic);
                    used = true;
                    print("id9");
                }
                if(MUseSId2 && !used){
                    ACCIO(SfarId, myMagic);
                    used = true;
                    print("id2");
                }
                NeedToUseMagic1 = false;
            }
            if(!NeedToUseMagic2){
            int ygt2 = yg;int xt=0, yt =0, vxt=0, vyt = 0; double k=1;
            if(Ws.get(1).state == 0){
                ArrayList<S> Sst = Ss;
                int index = Ws.get(1).getClosestS(Ss);
                if(index == Ws.get(0).getClosestS(Ss) && Ss.size() != 1){
                    Sst.remove(index);
                    index = Ws.get(1).getClosestS(Sst);
                }
                Ws.get(1).nearSId = Sst.get(index).id;
                System.err.println(Ws.get(1).nearSId);
                xt = Ss.get(index).x;
                yt = Ss.get(index).y;
                vxt = Ss.get(index).vx;
                vyt = Ss.get(index).vy;
                k=1;
                if(absDist(Bs.get(0) , Ws.get(1)) < 500 || absDist(Bs.get(1), Ws.get(1)) <500){
                    k = Math.random() + 0.5;
                    if(k>1){
                        k=0.98;
                    }
                }
                print("W2id4");
                System.out.println("MOVE " + (int)((xt+vxt)*k) + " " + (int)((yt+vyt)*k) + " 150");
                
            }else{
                //System.err.println(Ws.get(1).state);
                if(Ws.get(1).y > 3750){
                    ygt2 += 1100; 
                }else{
                    ygt2 -= 1100; 
                }
                print("W2id5");
                if(isSNearW(Ws.get(1), Ss)){
                    System.out.println("THROW "+ xg + " " + ygt2 + " 500");
                }else{
                    System.out.println("MOVE " + (int)((xt+vxt)*k) + " " + (int)((yt+vyt)*k) + " 150");
                }
            }
            }else{
                boolean used = false;
                if(MUseSId2 && !used){
                    ACCIO(SfarId, myMagic);
                    used = true;
                    print("W2id6");
                }
                if(MUseSId0 && !used){
                    OBLIV(BId, myMagic);
                    used = true;
                    print("W2id7");
                }
                if(MUseSId3 && !used){
                    FLIP(Ss.get(FlipSN).id, myMagic);
                    used = true;
                    print("W2id8");
                }
                if(MUseSId1 && !used){
                    PETRIF(SCritId, myMagic);
                    used = true;
                    print("W2id9");
                }
                NeedToUseMagic2 = false;
            }
            
            Ws.clear();
            Ss.clear();
            OWs.clear();
            Bs.clear();
            nMoveTemp1 -=1;nMoveTemp2 -=1;
            if(nMoveTemp1 < 0) nMoveTemp1 = 0;if(nMoveTemp2 < 0) nMoveTemp2 = 0;
        }
    }
}
class W{
    public int id, x,y,vx, vy, state, nearSId;
    public W(int id, int x,int y, int vx, int vy, int state){
        this.id = id;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.state = state;
    }
    public int getClosestS(ArrayList<S> ss){
        double min = Math.sqrt(Math.pow(ss.get(0).x - x, 2) + Math.pow(ss.get(0).y - y, 2));
        int iout=0;
        for(int i=0; i<ss.size(); i++){
            double c = Math.sqrt(Math.pow(ss.get(i).x - x, 2) + Math.pow(ss.get(i).y - y, 2));
            if(min > c){
                iout = i;
                min = c;
            }
        }
        return iout;
    }
}
class S{
    public int x,y,vx,vy, id;
    public boolean used3Spell;
    public S(int id, int x, int y, int vx, int vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.id = id;
    }
}
class OW {
    public int x,y,vx,vy,id,state;
    public OW(int id, int x, int y, int vx, int vy, int state){
        this.id = id;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.state = state;
    }
    public OW(){
        
    }
}
class B{
    public int x,y,vx,vy, id;
    public B(int id, int x, int y, int vx, int vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.id = id;
    }
}