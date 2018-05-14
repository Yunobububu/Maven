import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import sun.rmi.rmic.iiop.ClassPathLoader;

public class FindBeanFactory {
    public void test() {
        DefaultListableBeanFactory dbf = new DefaultListableBeanFactory();
        ClassPathResource cpr = new ClassPathResource("beans.xml");
        XmlBeanDefinitionReader xdr = new XmlBeanDefinitionReader(dbf);
        xdr.loadBeanDefinitions(cpr);
        FileSystemXmlApplicationContext fsxac = new FileSystemXmlApplicationContext();
    }

}
