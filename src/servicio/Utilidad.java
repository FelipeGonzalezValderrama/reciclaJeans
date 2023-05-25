package servicio;

public class Utilidad {
	
	
	public void espera() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	public void limpiar() {
		
		for (int i = 0; i <40; i++) {
			
			System.out.println();
			
		}
	}
}
