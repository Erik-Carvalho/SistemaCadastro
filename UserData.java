import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserData {
    private String nome;
    private String senha;
    private int tentativasFalhas;
    private LocalDateTime horarioDesbloqueio;

    public UserData(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.tentativasFalhas = 0;
        this.horarioDesbloqueio = LocalDateTime.now();
    }

    public boolean estaBloqueado() {
        return LocalDateTime.now().isBefore(horarioDesbloqueio);
    }

    public String getTempoRestante() {
        LocalDateTime agora = LocalDateTime.now();
        long minutos = ChronoUnit.MINUTES.between(agora, horarioDesbloqueio);
        long segundos = ChronoUnit.SECONDS.between(agora, horarioDesbloqueio) % 60;

        if (minutos > 0) {
            return minutos + " minuto(s) e " + segundos + " segundo(s).";
        }
        return segundos + " segundo(s).";
    }

    public void registrarFalha() {
        this.tentativasFalhas++;
    }

    public void bloquear(int minutos) {
        this.horarioDesbloqueio = LocalDateTime.now().plusMinutes(minutos);
    }

    public void resetarFalhas() {
        this.tentativasFalhas = 0;
    }

    //Getters
    public String getNome() { return nome; }
    public String getSenha() { return senha; }
    public int getTentativasFalhas() { return tentativasFalhas; }
}