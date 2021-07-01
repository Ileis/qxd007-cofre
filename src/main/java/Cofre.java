public class Cofre {

    private int volumeMax;
    private int volumeAtual;
    private boolean estado = true;
    private String itens;
    private double valor;


    public Cofre(int volumeMaximo) {
        this.volumeMax = volumeMaximo;
    }

    public int getVolume() {
        return volumeAtual;
    }

    public int getVolumeMaximo() {
        return volumeMax;
    }

    public int getVolumeRestante() {
        return (volumeMax - volumeAtual);
    }

    public boolean add(Item item) {
        if((item.getVolume() <= getVolumeRestante()) && estado){
            volumeAtual += item.getVolume();

            if(itens == null)
                itens = item.getDescricao();
            else
                itens = itens + ", " + item.getDescricao();

            return true;
        }
        return false;
    }

    public boolean add(Moeda moeda) {
        if((moeda.getVolume() <= getVolumeRestante()) && estado){
            volumeAtual += moeda.getVolume();
            valor += moeda.getValor();

            return true;
        }
        return false;
    }

    public String obterItens() {
        if((itens != null) && !estado){
            return itens;
        }else if(!estado)
            return "vazio";
        return null;
    }

    private String getItens() {
        return itens;
    }

    public double obterMoedas() {
        if(!estado){
            return valor;
        }
        return -1;
    }
    
    public boolean taInteiro() {
        return estado;
    }

    public boolean quebrar() {
        if(estado) {
            estado = false;

            return true;
        }
        return false;
    }
}
