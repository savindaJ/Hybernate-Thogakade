package lk.ijse.thogakade.util;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SavindaJ {
    String name() default "";

    enum MyType{
        SAMPLEMODEL
    }
}
