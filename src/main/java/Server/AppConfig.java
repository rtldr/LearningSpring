package Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {

//        @Bean
//        public JedisConnectionFactory redisConnectionFactory() {
//            return new JedisConnectionFactory();
//        }
//
//        @Bean
//        public RedisTemplate<String, Student> redisTemplate() {
//            RedisTemplate<String, Student> temp = new RedisTemplate<>();
//            temp.setConnectionFactory(redisConnectionFactory());
//            return temp;
//        }

}
