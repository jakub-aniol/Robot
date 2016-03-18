package Robot;

import org.apache.log4j.Logger;

public class Log4J {

    private final static Logger log = Logger.getLogger(Log4J.class);

    public static void main(String[] args) {







        log.info("hello Paulina");

       // System.out.println("lolo");
    }



}



  //  W przypadku logowania blędów, proponuję używać Logger.error(String, Throwable) zamiast Logger.error(String) - dołączenie obiektu wyjątku spowowoduje dodanie do logu stack trace'a, który zwykle bardzo się przydaje.
