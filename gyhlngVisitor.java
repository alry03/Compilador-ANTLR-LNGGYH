// Generated from gyhlng.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gyhlngParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gyhlngVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(gyhlngParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(gyhlngParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(gyhlngParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#listaVars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaVars(gyhlngParser.ListaVarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(gyhlngParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(gyhlngParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandos(gyhlngParser.ComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#programaBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramaBr(gyhlngParser.ProgramaBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#declaracoesBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoesBr(gyhlngParser.DeclaracoesBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#declaracaoBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracaoBr(gyhlngParser.DeclaracaoBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandosBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandosBr(gyhlngParser.ComandosBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoBr(gyhlngParser.ComandoBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#atribuicaoBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicaoBr(gyhlngParser.AtribuicaoBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoLeituraBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoLeituraBr(gyhlngParser.ComandoLeituraBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoEscritaBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoEscritaBr(gyhlngParser.ComandoEscritaBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoCondicionalBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoCondicionalBr(gyhlngParser.ComandoCondicionalBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoRepeticaoBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoRepeticaoBr(gyhlngParser.ComandoRepeticaoBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#subAlgBr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAlgBr(gyhlngParser.SubAlgBrContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(gyhlngParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(gyhlngParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoLeitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoLeitura(gyhlngParser.ComandoLeituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoEscrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoEscrita(gyhlngParser.ComandoEscritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoCondicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoCondicional(gyhlngParser.ComandoCondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoRepeticao(gyhlngParser.ComandoRepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(gyhlngParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#expressaoSimples}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoSimples(gyhlngParser.ExpressaoSimplesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(gyhlngParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(gyhlngParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#numero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(gyhlngParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link gyhlngParser#opRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpRelacional(gyhlngParser.OpRelacionalContext ctx);
}