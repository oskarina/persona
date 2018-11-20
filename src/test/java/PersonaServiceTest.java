import com.persona.domain.Persona;
import com.persona.domain.PersonaBuilder;
import com.persona.domain.PersonaRepository;
import com.persona.domain.PersonaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonaServiceTest {

    @InjectMocks
    private PersonaService personaService;

    @Mock
    private PersonaRepository personaRepository;

    @Before
    public void setUp() {
        Persona ramon1 = new PersonaBuilder().setNombre("Ramon").setApellido("Perez").setEdad(33).setDni("123456789").createPersona();
        Persona ramon2 = new PersonaBuilder().setNombre("Ramon").setApellido("Jimenez").setEdad(33).setDni("987654321").createPersona();
        List<Persona> personas = Arrays.asList(ramon1, ramon2);
        when(personaRepository.findAll(Matchers.<Example<Persona>>any())).thenReturn(personas);
    }

    @Test
    public void listarFiltradosTest() {
        Persona personaModelo = new PersonaBuilder().setNombre("Ramon").createPersona();
        Collection<Persona> personasEncontradas = personaService.listar(personaModelo);
        assertNotNull("Se esperaba resultados como respuesta", personasEncontradas);
        assertEquals("Deben existir dos personas con ese nombre",2, personasEncontradas.size());
        verify(personaRepository, atMost(1)).findAll(Matchers.<Example<Persona>>any());
        verifyNoMoreInteractions(personaRepository);
    }

}
