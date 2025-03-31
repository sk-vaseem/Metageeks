class Threading implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(" running: " + i);
            try {
                Thread.sleep(2000); // Pause for 700ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


