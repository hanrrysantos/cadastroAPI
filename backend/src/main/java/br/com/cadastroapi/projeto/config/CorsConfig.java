package br.com.cadastroapi.projeto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Indica que esta é uma classe de configuração
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Mapeia todas as rotas (/**) para a configuração CORS
        registry.addMapping("/**")

                // ESSE É O PONTO CHAVE: Permite requisições da sua origem frontend.
                // Troque a porta se você estiver usando uma diferente do 5500.
                .allowedOrigins("http://127.0.0.1:5500")

                // Permite os métodos que você está usando (POST, GET, etc.)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")

                // Opcional, mas útil para o navegador. Define por quanto tempo
                // a resposta de 'preflight' pode ser armazenada em cache (em segundos).
                .maxAge(3600);
    }
}