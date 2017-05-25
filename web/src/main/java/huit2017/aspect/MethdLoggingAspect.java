package huit2017.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethdLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethdLoggingAspect.class);

    public Object execute(ProceedingJoinPoint jp) throws Throwable {

        logger.info("メソッド開始: " + jp.getSignature());
        try {
            Object result = jp.proceed();
            logger.info("メソッド正常終了: " + jp.getSignature() + "戻り値=" + result);
            return result;
        } catch (Exception e) {
            logger.info("メソッド正常終了: " + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }
}
