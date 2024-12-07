package com.sms.smr.SchoolManagment;

import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SchoolManagmentApplicationTests {
	
 //   @Container
 //   @ServiceConnection
  //  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0");



    @Test
    void connectionEstablished() {
       // assertThat(postgres.isCreated()).isTrue();
        //assertThat(postgres.isRunning()).isTrue();
    }

	@Test
	void contextLoads() {
	}

}
