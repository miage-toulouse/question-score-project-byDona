package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {
    private ScoreCalculateur scoreCalculateur;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        scoreCalculateur = new ScoreCalculateur();
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
    }
    @Test
    public void testCalculeScore() {

        //when : liste de réponses contenant les valeurs 1 et 4
        List<Integer> indiceEtudiant;
        indiceEtudiant = new ArrayList<Integer>();
        indiceEtudiant.add(1);
        indiceEtudiant.add(4);

        //and : on demande le calcule du score
        Float resScore = scoreCalculateur.calculeScore(indiceEtudiant, questionAChoixMultiple);

        //then :
        assertEquals(new Float(0f), resScore);

        // when : liste de réponse contenant 2 et 3
        indiceEtudiant.clear();
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);

        //and : on demande le calcule du score
        resScore = scoreCalculateur.calculeScore(indiceEtudiant, questionAChoixMultiple);

        //then :
        assertEquals(new Float(2*100f/3f), resScore);

        // when : liste de reponse contenant 2, 3 et 5
        indiceEtudiant.clear();
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);
        indiceEtudiant.add(5);

        //and : on demande le calcule du score
        resScore = scoreCalculateur.calculeScore(indiceEtudiant, questionAChoixMultiple);

        //then : le score obtenu est 100
        assertEquals(new Float(100f), resScore);

        // when : liste de reponse contenant 1, 2, 3, 4, 5
        indiceEtudiant.clear();
        indiceEtudiant.add(1);
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);
        indiceEtudiant.add(4);
        indiceEtudiant.add(5);

        //and : on demande le calcule du score
        resScore = scoreCalculateur.calculeScore(indiceEtudiant, questionAChoixMultiple);

        //then :
        assertEquals(0f, resScore, 0.01f);

        // when : liste de reponse contenant 1, 2, 3, 4, 5
        indiceEtudiant.clear();
        indiceEtudiant.add(1);
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);

        //and : on demande le calcule du score
        resScore = scoreCalculateur.calculeScore(indiceEtudiant, questionAChoixMultiple);

        //then :
        assertEquals(16.66f, resScore, 0.01f);

    }
}