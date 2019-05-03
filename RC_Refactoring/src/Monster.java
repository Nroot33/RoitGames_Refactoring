import javax.swing.*;

class Monster extends Thread {
    JLabel M;
    JLabel U;
    int Delay;

    Monster(JLabel M, JLabel U, int Delay) {
        this.M = M;
        this.U = U;
        this.Delay = Delay;
    }

    public void run() {
        int x=M.getX(),y=M.getY();

        while(true) {
            if(U.getX() < M.getX())
                x = M.getX() - 5;
            else
                x = M.getX() + 5;

            if(U.getY() < M.getY())
                y = M.getY() - 5;
            else
                y = M.getY() + 5;

            M.setLocation(x, y);
            M.repaint();

            double CatchCondition_X = Math.abs((M.getX() -7.5) - (U.getX()-7.5));
            double CatchCondition_Y = Math.abs((M.getY() -7.5) - (U.getY()-7.5));

            try {
                if(CatchCondition_X < 10 && CatchCondition_Y < 10) {
                    System.exit(0);
                }
                sleep(Delay);
            }catch(InterruptedException e) {
                return;
            }
        }
    }
}