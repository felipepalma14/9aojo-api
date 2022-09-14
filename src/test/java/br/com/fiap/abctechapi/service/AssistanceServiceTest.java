package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;
@SpringBootTest
class AssistanceServiceTest {

    @Mock
    private AssistanceRepository repository;
    private AssistanceService service;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        service = new AssistanceServiceImpl(repository);
    }

    @DisplayName("Listando assistencias disponiveis :: Sucesso")
    @Test
    public void list_success(){
        Assistance assistance1 = new Assistance(1L, "Mock 1", "Description 1");
        Assistance assistance2 = new Assistance(2L, "Mock 2", "Description 2");

        when(repository.findAll()).thenReturn(List.of(assistance1,assistance2));

        List<Assistance> values = service.getAssistanceList();

        Assertions.assertEquals(2, values.size());
        Assertions.assertEquals(values.get(0), assistance1);
        Assertions.assertEquals(values.get(1), assistance2);
    }


    @DisplayName("Listando assistencias indisponiveis :: Erro")
    @Test
    public void list_error(){

        when(repository.findAll()).thenReturn(List.of());

        List<Assistance> values = service.getAssistanceList();

        Assertions.assertEquals(0, values.size());
    }
}