package br.com.blz.testjava;


import br.com.blz.testjava.DTO.InvetoryDTO;
import br.com.blz.testjava.DTO.ProdutoDTO;
import br.com.blz.testjava.DTO.TypeEnum;
import br.com.blz.testjava.DTO.WarehousesDTO;
import br.com.blz.testjava.entity.Invetory;
import br.com.blz.testjava.entity.Produto;
import br.com.blz.testjava.entity.Warehouses;
import br.com.blz.testjava.repositories.ProdutoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoControllerTest {


    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {
        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);
        assertNotNull("the JSON message converter must not be null",
            this.mappingJackson2HttpMessageConverter);
    }


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();




    }


    @Test
    public void testCriarProduto () throws Exception {
        ProdutoDTO Amend = new ProdutoDTO(2L,"Amend Luxe Creations Blonde Care",
            new InvetoryDTO(Arrays.asList(
                new WarehousesDTO("SP", 15, TypeEnum.PHYSICAL_STORE),
                new WarehousesDTO("PA", 10, TypeEnum.ECOMMERCE)
            )));


        this.mockMvc.perform(post("/produto/add")
            .content(this.json(Amend))
            .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isCreated());
    }


    @Test
    public void testApagarProduto() throws Exception {

        Produto DoveMen = new Produto("Dove Men",
            new Invetory( Arrays.asList(
                new Warehouses("SP", 15, TypeEnum.PHYSICAL_STORE),
                new Warehouses("MG", 10, TypeEnum.PHYSICAL_STORE),
                new Warehouses("RJ", 15, TypeEnum.ECOMMERCE),
                new Warehouses("PA", 10, TypeEnum.ECOMMERCE)
            )),3L);

        this.produtoRepository.save(DoveMen);

        this.mockMvc.perform(delete("/produto/3"))
            .andExpect(status().isOk());
    }

    @Test
    public void testRecuperaProduto() throws Exception {

        Produto DoveMen = new Produto("Dove Men",
            new Invetory( Arrays.asList(
                new Warehouses("SP", 15, TypeEnum.PHYSICAL_STORE),
                new Warehouses("MG", 10, TypeEnum.PHYSICAL_STORE),
                new Warehouses("RJ", 15, TypeEnum.ECOMMERCE),
                new Warehouses("PA", 10, TypeEnum.ECOMMERCE)
            )),1L);

        this.produtoRepository.save(DoveMen);

        ProdutoDTO DoveMenDTO = new ProdutoDTO(1L,"Dove Men",
            new InvetoryDTO( 50,Arrays.asList(
                new WarehousesDTO("SP", 15, TypeEnum.PHYSICAL_STORE),
                new WarehousesDTO("MG", 10, TypeEnum.PHYSICAL_STORE),
                new WarehousesDTO("RJ", 15, TypeEnum.ECOMMERCE),
                new WarehousesDTO("PA", 10, TypeEnum.ECOMMERCE)
            )),true);


        this.mockMvc.perform(get("/produto/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(this.json(DoveMenDTO)));
    }


    @After
    public void clean() {
        this.produtoRepository.deleteAll();
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
            o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }


}
