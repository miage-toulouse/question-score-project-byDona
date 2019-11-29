package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {
    private QuestionAChoixMultiple uneQuestion;
    private List <Integer> reponse;

    @Before
    public void setUp() throws Exception {
        // given : un object de tyoe QuestionAChoixExclusif
        reponse = new ArrayList<Integer>();
        reponse.add(2);
        reponse.add(3);
        uneQuestion = new QuestionAChoixMultiple("un énoncé", reponse);
    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnnonce = uneQuestion.getEnonce();

        //then : l'énoncé est non null
        assertNotNull(resEnnonce);
        // and : l'énoncé est bien celui fourni à la construction
        assertEquals("un énoncé", resEnnonce);
    }

    @Test
    public void testGetScoreForIndice() {
        //when : un étudiant fourni les deux indices correspondant à la bonne réponse
        List<Integer> indiceEtudiant;
        indiceEtudiant = new ArrayList<Integer>();
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);
        Float resScore = new Float(0f);

        //and : on demande le calcule du score
        for (int i = 0; i < indiceEtudiant.size(); i++)
        {

            resScore += uneQuestion.getScoreForIndice(indiceEtudiant.get(i));
        }

        //then : le score obtenu est 100
        assertEquals(new Float(100f), resScore);

        // when : quand un étudiant fourni l'indice correspondant à une seule réponse
        indiceEtudiant.clear();
        indiceEtudiant.add(2);

        //and : on demande le calcule du score
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant.get(0));

        //then :
        assertEquals(new Float(100f/reponse.size()), resScore);

        // when : quand un étudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant.clear();
        indiceEtudiant.add(1);

        //and : on demande le calcule du score
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant.get(0));


        //then :
        assertEquals(new Float(0f), resScore);
    }
}