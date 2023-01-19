import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ficheros {

	// ESCRIBIMOS FICHEROS DE TEXTOS
	public void ficherosTexto(String ficheroTexto, String contacto) {
		
		try {
			File f = new File(ficheroTexto);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(contacto + "\n");
			
			bw.close();
			fw.close();
		} catch(Exception e) {
			System.out.println("Fichero de texto no creado");
		}
	}
	
	// ESCRIBIMOS FICHEROS BINARIOS
	public void ficherosBinarios(String ficheroBinario, String contacto) {
		
		try {
			File f = new File(ficheroBinario);
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF(contacto + "\n");
			
			dos.close();
			fos.close();
		} catch(Exception e) {
			System.out.println("Fichero binario no creado");
		}
	}
	
	// ESCRIBIMOS FICHEROS SERIALIZABLES
	public void ficherosSerializables(String ficheroSerializable, ArrayList<Contacto> listaContactos) {
		
		try {
			File f = new File(ficheroSerializable);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(listaContactos);
			
			oos.close();
			fos.close();
		} catch(Exception e) {
			System.out.println("Fichero serializable no creado");
		}
	}
	
	// LEEMOS FICHERO TEXTO
	public void leerFicheroTexto(String ficheroTexto) {
		
		try {
			FileReader fr = new FileReader(ficheroTexto);
			BufferedReader br = new BufferedReader(fr);
			
			String contacto;
			
			while((contacto = br.readLine()) != null) {
				System.out.println(contacto);
			}
			
			br.close();
			fr.close();
		} catch(Exception e) {}
	}
	
	// ELIMINAR FICHERO
	public void eliminarFichero(String fichero) {
		
		try {
			File f = new File(fichero);
			if(f.exists()) {
				f.delete();
			}
		} catch(Exception e) {}
	}
}