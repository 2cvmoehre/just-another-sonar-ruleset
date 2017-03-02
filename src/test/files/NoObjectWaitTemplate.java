
public class NoObjectWaitTemplate
{

    public void dummy() throws InterruptedException
    {
        Object semaphore = new Object();
        semaphore.wait();// Noncompliant

        Integer i = new Integer(1);
        i.wait();// Noncompliant
        i.wait(100);// Noncompliant
        i.wait(100, 10);// Noncompliant
    }

}
