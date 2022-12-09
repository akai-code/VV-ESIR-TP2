package fr.istic.vv;

import java.util.ArrayList;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.VoidVisitorWithDefaults;


// This class visits a compilation unit and
// prints all public enum, classes or interfaces along with their public methods
public class PublicElementsPrinter extends VoidVisitorWithDefaults<Void> {

    ArrayList<ArrayList<String>> tabl = new ArrayList<>();
	ArrayList<FieldDeclaration> filedTabl = new ArrayList<>();

    @Override
    public void visit(CompilationUnit unit, Void arg) {
        for(TypeDeclaration<?> type : unit.getTypes()) {
            type.accept(this, null);
        }
    }

    public void visitTypeDeclaration(TypeDeclaration<?> declaration, Void arg) {
        tabl.add(new ArrayList<String>());
        for(MethodDeclaration method : declaration.getMethods()) {
            method.accept(this, arg);
        }
        tabl.add(new ArrayList<String>());
        // Printing nested types in the top level
        for(BodyDeclaration<?> member : declaration.getMembers()) {
            if (member instanceof TypeDeclaration)
                member.accept(this, arg);
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration declaration, Void arg) {
        visitTypeDeclaration(declaration, arg);
        for(FieldDeclaration fd : declaration.getFields()) {
    		if(fd.isPrivate()) {
    			tabl.get(tabl.size()-1).add(fd.toString().toLowerCase());
    		}
    	}
    }

    @Override
    public void visit(EnumDeclaration declaration, Void arg) {
        visitTypeDeclaration(declaration, arg);
    }

    @Override
    public void visit(MethodDeclaration declaration, Void arg) {
        if(declaration.isPublic()) {
        	tabl.get(tabl.size()-1).add(declaration.getNameAsString().toLowerCase());
        }

    }
    public ArrayList<ArrayList<String>> getData() {
    	return tabl;
    }
}


