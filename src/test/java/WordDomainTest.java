import com.sleep.wechat.domain.WordDomain;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * 测试对象equals
 */
public class WordDomainTest {

    @Test
    public void equalsTest(){
        WordDomain wd1 = new WordDomain("测试");
        WordDomain wd2 = new WordDomain("测试");
        WordDomain wd3 = new WordDomain("测试",new Date());
        WordDomain wd4 = new WordDomain("测试123");
        Assert.assertTrue(wd1.equals(wd2));
        Assert.assertTrue(wd1.equals(wd3));
        Assert.assertTrue(wd2.equals(wd3));
        Assert.assertFalse(wd1.equals(wd4));
        Assert.assertFalse(wd2.equals(wd4));
        Assert.assertFalse(wd3.equals(wd4));
    }

}
