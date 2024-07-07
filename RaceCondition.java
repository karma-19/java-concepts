public class RaceCondition {

    class Shared {
        private  boolean  flag = false; //way 1 :  add volatile here

        public synchronized void setFlag(boolean flag){ // way 2 : add synchronized on methods
            this.flag = flag;
        }

        public synchronized boolean getFlag() {
            return flag;
        }
    }

    public void raceCondition() {

        Shared shared = new Shared();

        new Thread(() -> {
            System.out.println("t1 started.");
            //some logic
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("logic t1 completed.");
            shared.setFlag(true);
            System.out.println("Flag set in t1 completed.");
        }).start();

        new Thread(() -> {
            System.out.println("t2 started.");
            while(!shared.getFlag()) {

            }
            System.out.println("t2 completed.");
        }).start();
    }
}
